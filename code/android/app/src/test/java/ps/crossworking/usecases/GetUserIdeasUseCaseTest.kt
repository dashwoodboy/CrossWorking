package ps.crossworking.usecases

import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import ps.crossworking.mockRepositories.IdeaRepositoryMock
import ps.crossworking.model.ShortIdea
import ps.crossworking.screen.idea.feed.GetFeedUseCase
import ps.crossworking.screen.idea.userlist.GetUserIdeasUseCase
import ps.crossworking.testIdea
import ps.crossworking.testIdeaShort

class GetUserIdeasUseCaseTest  {

    private lateinit var getUserIdeasUseCase: GetUserIdeasUseCase
    private lateinit var repo: IdeaRepositoryMock

    @Before
    fun setUp() {
        repo = IdeaRepositoryMock()
        repo.startWithDate(testIdea.ideaId)
        getUserIdeasUseCase = GetUserIdeasUseCase(repo)
    }

    @Test
    fun `get feed page when exists more`() {
        runBlocking {
            val ideaList = getUserIdeasUseCase("", 0)
            assertEquals(testIdeaShort, ideaList[0])
        }

    }

    @Test
    fun `get feed page when there is no more`() {
        runBlocking {
            val ideaList = getUserIdeasUseCase("", 1)
            assertEquals(emptyList<ShortIdea>(), ideaList)
        }
    }
}