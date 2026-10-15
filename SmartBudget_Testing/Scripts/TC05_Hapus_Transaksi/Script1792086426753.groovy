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
import com.kms.katalon.core.util.KeywordUtil

Mobile.startExistingApplication('com.SmartBudget.GoldFlyApps')
Mobile.delay(3)
Mobile.tap(findTestObject('Object Repository/btn_mulai'), 10)

Mobile.waitForElementPresent(findTestObject('Object Repository/item_transaksi'), 15)
String saldoSebelum = Mobile.getText(findTestObject('Object Repository/txt_saldo'), 10)

Mobile.tap(findTestObject('Object Repository/item_transaksi'), 10)
Mobile.tap(findTestObject('Object Repository/btn_hapus'), 10)
Mobile.tap(findTestObject('Object Repository/btn_konfirmasi'), 10)
Mobile.delay(2)

Mobile.waitForElementPresent(findTestObject('Object Repository/txt_saldo'), 10)
String saldoSesudah = Mobile.getText(findTestObject('Object Repository/txt_saldo'), 10)

// ASSERTION: saldo berubah, dan sesuai salah satu hasil yang valid
if (saldoSebelum == saldoSesudah) {
	KeywordUtil.markFailed('Saldo tidak berubah setelah hapus: ' + saldoSesudah)
}
if (!(saldoSesudah in ['Saldo: -Rp 25.000', 'Saldo: Rp 100.000'])) {
	KeywordUtil.markFailed('Saldo setelah hapus tidak sesuai: ' + saldoSesudah)
}
KeywordUtil.logInfo('Saldo sebelum: ' + saldoSebelum + ' | sesudah: ' + saldoSesudah)

Mobile.closeApplication()