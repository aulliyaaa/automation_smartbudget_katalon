import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.llm.keyword.LlmKeywords as LLM
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

Mobile.startExistingApplication('com.SmartBudget.GoldFlyApps')
Mobile.delay(3)
Mobile.tap(findTestObject('Object Repository/btn_mulai'), 10)

Mobile.waitForElementPresent(findTestObject('Object Repository/txt_saldo'), 15)
Mobile.verifyElementText(findTestObject('Object Repository/txt_saldo'), 'Saldo: Rp 75.000')

Mobile.tap(findTestObject('Object Repository/tab_dompet'), 10)

// ASSERTION: saldo di kartu Uang tunai harus sama
Mobile.waitForElementPresent(findTestObject('Object Repository/txt_saldo_dompet'), 10)
Mobile.verifyElementText(findTestObject('Object Repository/txt_saldo_dompet'), 'Rp 75.000')

Mobile.closeApplication()