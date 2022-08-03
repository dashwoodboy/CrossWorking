# Autenticação

## Necessidade

Para que uma plataforma seja o mais util e personalizável possível é necessário que exista a capacidade de um utilizador aderir à mesma, fornecendo dados que o identifiquem e que lhe permitam garantir acesso às funcionalidades necessárias garantindo ao mesmo tempo o isolamento entra a sua informação e a informação de outras pessoas. Para tal foi necessário desenvolver um mecanismo de autenticação e controlo de acesso, a ser implementado que na aplicação doo lado cliente como no serviço backend.

## Tecnologia utilizada

A autenticação de um utilizador é uma ação extremamente complexa, uma vez que pressupõem a circulação de dados sensíveis, e que deverão ser protegidos, entre a aplicação apresentada ao cliente e o servidor usado como suporte. Assim é necessário cumprir determinadas regras de segurança que poderiam alargar o tempo necessário para desenvolver a plataforma CrossWorking, podendo mesmo comprometer a conclusão do projeto dentro do prazo estipulado.

Por forma a reduzir o tempo necessário para a implementação de um serviço de autenticação, são hoje disponibilizados diversos serviços se autenticação. Destes serviços foi tomada como opção a utilização do Firebase Auth nas aplicações client side, e Firebase Admin na aplicação backEnd(Servidor).

O serviço Firebase foi selecionado pela sua fácil adaptação à framework Android, e pelos seus serviços extra que permitem criação de contas de utilizador e inicio de sessão através de contas já existentes noutras plataformas como o Facebook e o Gmail.

## Aplicação cliente

### Criação de conta de utilizador

Para que um utilizador possa ter uma conta através da qual é identificado e propõem aos outro utilizadores ideias, é necessário a existência de duas activities nas quais os utilizadores poderão criar uma conta e iniciar sessão com a mesma.

Quando ao utilizador é apresentada a activity de inicio de sessão,é solicitada sua informação pessoal(email, username, password), necessária para identificar o utilizador. Uma vez acionado o botão de criação de utilizador, é realizada uma chamada ao método `createUserWithEmailAndPassword(email, password)` presente na API do Firebase Auth, e que permite a criação de uma conta de utilizador no servidor de autenticação firebase, a este método é possível associar um listener que será chamado uma vez criada a conta ou caso tenha ocorrido um erro. No caso de uma conta ter sido criada com sucesso, fica disponível através da propriedade currentUser uma instância do utilizador criado, o qual contém a informação do utilizador e o seu identificador único(uid).

Caso o processo de criação de utilizador e obtenção da instância de current user tenham sucedido, segue-se a criação do utilizador no servidor CrossWorking, onde é criado um utilizador com a informação fornecida pelo utilizador e com o uid gerado pelo servidor de autenticação FireBase Auth; o servidor irá responder com uma mensagem contendo o status code `201 created`.

![alt text](https://github.com/lourencovala/crossworking-project/blob/main/docs/auth/SignUpDiagram.jpg)

### Inicio de sessão

Se um utilizador já tiver criado a sua conta, e não tiver sessão iniciada na aplicação, é apresentada uma activity onde deverá indicar o seu email e a sua password. Após acionado o botão de signIn é realizada uma chamada ao método `signInWithEmailAndPassword(email, password)`, presente na API do Firebase Auth, que permite à semelhança da criação  de utilizador associar um listener que será chamado após conclusão do pedido de login. No caso de sucesso, é obtida a instância de FirebaseUser, este objeto para além da informação do utilizador contem também um método `getIdToken`, que retorna um token indicado para autenticação num servidor. Uma vez decorrido de acordo a autenticação e na posse do token gerado pela FireBase Auth, é realizado um pedido `get` ao servidor CrossWorking, para obtenção do utilizador autenticado, colocando no authorization token o token firebase. O servidor deverá responder com a instância do utilizador.

![alt text](https://github.com/lourencovala/crossworking-project/blob/main/docs/auth/SignInDiagram.jpg)

Todos os pedidos subsequentes ao servidor CrossWorking devem conter o authorization token associado ao utilizador em questão para que os pedidos possam ser autorizados.

## Servidor BackEnd

### Criação de conta

Quando o servidor CrossWorking recebe um pedido de criação de utilizador, guarda a instância de utilizador que recebe, a qual contem para além da informação providenciada pelo próprio utilizador o uid gerado pelo servidor de autenticação. Uma vez guardada esta instância o utilizador passa a estar efetivamente registado na plataforma. Os pedidos de obtenção e criação de um utilizador não têm associados qualquer tipo de autenticação, pelo que o header Authentication poderá ser enviado sem qualquer valor.

![alt text](https://github.com/lourencovala/crossworking-project/blob/main/docs/auth/SignUpDiagram.jpg)

### Pedido com sessão iniciada

Uma vez iniciada a sessão do lado do cliente, todos os pedidos `Get` ao servidor passam a necessitar de um Authorization Header, header este que é gerado pelo servidor de autenticação Firebase Auth. Recebido o pedido no servidor CrossWorking o mesmo é intercetado num filter, este filter irá obter o header de autenticação e extrair o token do mesmo. Através de uma api disponibilizada pelo servidor de autenticação, denominada de `Firebase Admin`,  é disponibilizado o método verifyIdToken, que descodificará e validará o token recorrendo ao servidor de autenticação. Se a validação suceder o pedido prosseguirá até um controlador que possa atender a rota do pedido, caso contrario, será gerada uma resposta de erro com o status code `401 Unauthorized`.

Caso a ação seja de `Post` ou de `Put` a verificação ocorre exatamente da mesma forma, no entanto existe um procedimento adicional onde se extrai do token o uid que identifica o utilizador ao qual o token pertence. Se o uid extraído do token corresponder ao uid do utilizador indicado no path o pedido é atendido por uma das rotas definidas nos controladores existentes, caso contrário será automaticamente gerada uma resposta com o código de erro `401 Unauthorized`.

![alt text](https://github.com/lourencovala/crossworking-project/blob/main/docs/auth/FetchDiagram.jpg)

## Diagramas sistema de autenticação

Os diagramas de bloco que se seguem representam o sistema de autenticação nos seu 3 estados sendo estes respetivamente: sem conta de utilizador na plataforma, sem sessão iniciada na plataforma, sessão iniciada na plataforma.

### Criação de conta

![alt text](https://github.com/lourencovala/crossworking-project/blob/main/docs/auth/SignUpDiagram.jpg)

### Inicio de sessão

![alt text](https://github.com/lourencovala/crossworking-project/blob/main/docs/auth/SignInDiagram.jpg)

### Pedido com sessão iniciada

![alt text](https://github.com/lourencovala/crossworking-project/blob/main/docs/auth/FetchDiagram.jpg)

## Referencias
