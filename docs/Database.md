# Tables for Server Postgres Database

## User

Represents a User, containing it's account and profile information.

* `userId` - Unique user identifier. Also on Firebase Authentication Database.

  * mandatory
  * non editable
  * type: **String**
  * example: `FEmLpMi4rNZYTAOLUGRzxeZfhyH2`

* `name` - Display name chosen by user.

  * not mandatory
  * editable
  * type: **String**
  * example: `User 1`

* `email` - Unique email.

  * mandatory
  * non editable
  * type: **String**
  * example: `a@gmail.com`

* `about` - User detail on that skill.

  * not mandatory
  * editable
  * type: **String**
  * example: `I am User 1 and I do X.`

* `profileImage` - Url to online image for user profile.

  * not mandatory
  * editable
  * type: **String**
  * example: `https://pbs.twimg.com/profile_images/1223780461048213505/uxSoqND1_400x400.jpg`

## Idea

Represents an idea created by a user.

* `ideaId` - Unique idea identifier.

  * mandatory
  * non editable
  * type: **[UUID](https://www.rfc-editor.org/rfc/rfc4122.html)**
  * example: `c5e36241-e105-4d6c-9884-da5105473c48`

* `userId` - Unique user identifier. Also on Firebase Authentication Database.

  * mandatory
  * non editable
  * type: **String**
  * example: `FEmLpMi4rNZYTAOLUGRzxeZfhyH2`

* `title` - Tile for an idea.

  * mandatory
  * editable
  * type: **String**
  * example: `Idea 1`

* `smallDescription` - A small description of the idea.

  * mandatory
  * editable
  * type: **String**
  * example: `This is an idea about X.`

* `description` - Full description of the idea.

  * mandatory
  * editable
  * type: **String**
  * example: `This is an idea about X, with relation to Y and Z. With interest in something and inspired another thing.`

* `date` - Date of creation.

  * mandatory
  * non editable
  * type: **Date**
  * example: `2022-04-27`

## Category

Represents a category for skills.

* `categoryId` - Unique category identifier.

  * mandatory
  * non editable
  * type: **[UUID](https://www.rfc-editor.org/rfc/rfc4122.html)**
  * example: `c5e36241-e105-4d6c-9884-da5105473c48`

* `name` - Unique name for category.

  * mandatory
  * non editable
  * type: **String**
  * example: `IT`

## Skill

Represents a skill.

* `skillId` - Unique skill identifier.

  * mandatory
  * non editable
  * type: **[UUID](https://www.rfc-editor.org/rfc/rfc4122.html)**
  * example: `c5e36241-e105-4d6c-9884-da5105473c48`

* `name` - Unique name for skill.

  * mandatory
  * non editable
  * type: **String**
  * example: `Prolog`

* `categoryId` - Unique category identifier.

  * mandatory
  * non editable
  * type: **[UUID](https://www.rfc-editor.org/rfc/rfc4122.html)**
  * example: `c5e36241-e105-4d6c-9884-da5105473c48`

## UserSkill

Links a user to a particular skill.

* `userId` - Unique user identifier. Also on Firebase Authentication Database.

  * mandatory
  * non editable
  * type: **String**
  * example: `FEmLpMi4rNZYTAOLUGRzxeZfhyH2`

* `skillId` - Unique skill identifier.

  * mandatory
  * non editable
  * type: **[UUID](https://www.rfc-editor.org/rfc/rfc4122.html)**
  * example: `c5e36241-e105-4d6c-9884-da5105473c48`

* `about` - User detail on that skill.

  * not mandatory
  * editable
  * type: **String**
  * example: `I learned this in school.`

## IdeaSkill

Links an idea to a particular skill.

* `ideaId` - Unique idea identifier.

  * mandatory
  * non editable
  * type: **[UUID](https://www.rfc-editor.org/rfc/rfc4122.html)**
  * example: `c5e36241-e105-4d6c-9884-da5105473c48`

* `skillId` - Unique skill identifier.

  * mandatory
  * non editable
  * type: **[UUID](https://www.rfc-editor.org/rfc/rfc4122.html)**
  * example: `c5e36241-e105-4d6c-9884-da5105473c48`

* `about` - Idea necessities from that skill.

  * not mandatory
  * editable
  * type: **String**
  * example: `I need this for X.`

## Candidate

Represents a user applying to an idea.

* `userId` - Unique user identifier. Also on Firebase Authentication Database.

  * mandatory
  * non editable
  * type: **String**
  * example: `FEmLpMi4rNZYTAOLUGRzxeZfhyH2`

* `ideaId` - Unique idea identifier.

  * mandatory
  * non editable
  * type: **[UUID](https://www.rfc-editor.org/rfc/rfc4122.html)**
  * example: `c5e36241-e105-4d6c-9884-da5105473c48`

* `status` - Status of candidature.

  * mandatory
  * editable
  * type: **String**
  * example: `pending` or `accepted` or `declined`

* `createdDate ` - Date of creation.

  * mandatory
  * non editable
  * type: **Date**
  * example: `2022-04-27`

* `lastUpdateDate ` - Date of last update.

  * mandatory
  * editable
  * type: **Date**
  * example: `2022-04-27`
