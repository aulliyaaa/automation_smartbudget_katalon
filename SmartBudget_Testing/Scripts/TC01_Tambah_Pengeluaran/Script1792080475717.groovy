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

Mobile.waitForElementPresent(findTestObject('Object Repository/btn_tambah'), 15)
Mobile.verifyElementText(findTestObject('Object Repository/txt_saldo'), 'Saldo: Rp 0')

Mobile.tap(findTestObject('Object Repository/btn_tambah'), 10)
Mobile.tap(findTestObject('Object Repository/tab_pengeluaran'), 10)

// Jumlah 25000 lewat keypad
Mobile.tap(findTestObject('Object Repository/field_jumlah'), 10)
Mobile.tap(findTestObject('Object Repository/key_2'), 10)
Mobile.tap(findTestObject('Object Repository/key_5'), 10)
Mobile.tap(findTestObject('Object Repository/key_0'), 10)
Mobile.tap(findTestObject('Object Repository/key_0'), 10)
Mobile.tap(findTestObject('Object Repository/key_0'), 10)
Mobile.tap(findTestObject('Object Repository/btn_ok'), 10)

Mobile.setText(findTestObject('Object Repository/field_keterangan'), 'makan', 10)
Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/dropdown_kategori'), 10)
Mobile.tap(findTestObject('Object Repository/kategori_makanan'), 10)
Mobile.tap(findTestObject('Object Repository/btn_simpan'), 10)

// ASSERTION
Mobile.waitForElementPresent(findTestObject('Object Repository/txt_saldo'), 10)
Mobile.verifyElementText(findTestObject('Object Repository/txt_saldo'), 'Saldo: -Rp 25.000')
Mobile.verifyElementExist(findTestObject('Object Repository/item_transaksi'), 10)
Mobile.verifyElementNotExist(findTestObject('Object Repository/txt_kosong'), 5)

Mobile.closeApplication()