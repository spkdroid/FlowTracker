package ca.rovbot.flowtracker.Repository

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import ca.rovbot.flowtracker.model.PeriodLogTable
import ca.rovbot.flowtracker.repository.LogRepository
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class RepositoryTest {

    @Test
    fun getLogRepositoryTest() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        val LogRepository  = LogRepository(appContext)
        Assert.assertNotNull(LogRepository)
    }

    @Test
    fun insertLogTest() {
        val appContext = InstrumentationRegistry.getTargetContext()
        val LogRepository  = LogRepository(appContext)
        val count = LogRepository.allLogs.count()
        LogRepository.addLog(PeriodLogTable(count+1,"titleText","typeText","dateText","descriptionText"))
        LogRepository.addLog(PeriodLogTable(count+2,"titleText","typeText","dateText","descriptionText"))
        LogRepository.addLog(PeriodLogTable(count+3,"titleText","typeText","dateText","descriptionText"))
        LogRepository.addLog(PeriodLogTable(count+4,"titleText","typeText","dateText","descriptionText"))
        Assert.assertEquals(LogRepository.allLogs.count()==count+4,true)
    }

    @Test
    fun deleteLogTest() {
        val appContext = InstrumentationRegistry.getTargetContext()
        val LogRepository  = LogRepository(appContext)
        val count = LogRepository.allLogs.count();
        LogRepository.deleteLog(LogRepository.allLogs.first())
        Assert.assertEquals(count-1,LogRepository.allLogs.count())
    }

    @Test
    fun RetriveLogById(){
        val appContext = InstrumentationRegistry.getTargetContext()
        val LogRepository  = LogRepository(appContext)
        val count = LogRepository.allLogs
        val periodTable = LogRepository.getLogById(count.first().uid)
        Assert.assertNotNull(periodTable);
    }



}