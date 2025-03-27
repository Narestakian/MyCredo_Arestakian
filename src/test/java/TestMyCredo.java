
import org.credoBank.testAutomation.myCredo.data.DataControllerAmountTransfer;
import org.credoBank.testAutomation.myCredo.data.DataControllerUserTransfer;
import org.credoBank.testAutomation.myCredo.steps.BalanceValidationSteps;
import org.credoBank.testAutomation.myCredo.steps.TotalBalanceCalculator;
import org.credoBank.testAutomation.myCredo.authorizePages.steps.AuthorizePagesMyCredo;
import org.credoBank.testAutomation.myCredo.stepsSelenide.TransferFromAccountSteps;
import org.credoBank.testAutomation.myCredo.stepsSelenide.TransferToOwnSteps;
import org.credoBank.testAutomation.myCredo.steps.UserCardSteps;
import org.credoBank.testAutomation.myCredo.stepsSelenide.*;
import org.credoBank.testAutomation.myCredo.utils.SetUp;
import org.testng.annotations.Test;



public class TestMyCredo extends SetUp {

    AuthorizePagesMyCredo authorizePagesMyCredo = new AuthorizePagesMyCredo();
    DataControllerUserTransfer dataControllerUserTransfer = new DataControllerUserTransfer();
    DataControllerAmountTransfer dataControllerAmountTransfer = new DataControllerAmountTransfer();
    MyCredoProductsSteps myCredoProductsSteps = new MyCredoProductsSteps();
    MyCredoEvoCardsSteps myCredoEvoCardsSteps = new MyCredoEvoCardsSteps();
    UserCardSteps userCardSteps = new UserCardSteps();
    CardBlockingUnblockingSteps cardBlockingUnblockingSteps = new CardBlockingUnblockingSteps();
    CardPinChangeSteps cardPinChangeSteps = new CardPinChangeSteps();
    CardSwitchedSteps cardSwitchedSteps = new CardSwitchedSteps();
    DownloadingRequisitesSteps downloadingRequisitesSteps = new DownloadingRequisitesSteps();
    TransferFromAccountSteps transferFromAccountSteps = new TransferFromAccountSteps();
    TransferToOwnSteps transferToOwnSteps = new TransferToOwnSteps();
    BalanceValidationSteps balanceValidationSteps = new BalanceValidationSteps();
    TotalBalanceCalculator totalBalanceCalculator = new TotalBalanceCalculator();



    @Test(priority = 1)
    public void myCredoAuthorizationSteps() {
        authorizePagesMyCredo.openMyCredoPage();
        authorizePagesMyCredo.checkSubmitButtonIsDisabled();
        authorizePagesMyCredo.authorize(
                dataControllerUserTransfer.getUserName(),
                dataControllerUserTransfer.getPassword()
        );
        authorizePagesMyCredo.checkSubmitButtonIsEnable();
        authorizePagesMyCredo.checkOtpSubmitButtonIsDisabled();
        authorizePagesMyCredo.setOtp(dataControllerUserTransfer.getOtpInput());
        authorizePagesMyCredo.clickEasyAuthCloseButtonIfPresent();
    }

    @Test(priority = 2)
    public void myCredoProductsSteps(){
        myCredoProductsSteps.clickOnProductsButton();
        myCredoProductsSteps.clickAccountAndCardsDropDown();
    }

    @Test(priority = 3)
    public void myCredoEvoCardsSteps(){
        myCredoEvoCardsSteps.findHighestEvoCard();
    }


    @Test(priority = 4)
    public  void userCardSteps(){
         userCardSteps.checkEvoCardAndBalances();


    }

    @Test(priority = 5)
    public void totalBalanceCalculator(){
        totalBalanceCalculator.calculateTotalBalance();
    }


    @Test(priority = 6)
    public void cardBlockingUnblockingSteps(){
        cardBlockingUnblockingSteps.clickCardBlockingUnblockingButton();
        cardBlockingUnblockingSteps.clickCardCancelButton();
        cardBlockingUnblockingSteps.clickCardBlockingUnblockingButton();
        cardBlockingUnblockingSteps.clickClosePopupButton();
        cardBlockingUnblockingSteps.clickCardBlockingUnblockingButton();
        cardBlockingUnblockingSteps.clickLockCardButton();
        cardBlockingUnblockingSteps.checkCardBlock();
        cardBlockingUnblockingSteps.checkNotificationBlockedMessage();
        cardBlockingUnblockingSteps.clickCardUnblockButton();
        cardBlockingUnblockingSteps.clickUnblockButton();
        cardBlockingUnblockingSteps.checkCardUnblock();
    }

    @Test(priority = 7)
    public void cardPinChangeSteps(){
        cardPinChangeSteps.clickPinResetButton();
        cardPinChangeSteps.clickClosePinResetButton();
        cardPinChangeSteps.clickPinResetButton();
        cardPinChangeSteps.clickCloseIcon();
        cardPinChangeSteps.clickPinResetButton();
        cardPinChangeSteps.clickResetEvoCardPinButton();
        cardPinChangeSteps.checkConfirmEvoCardOtpButton();
        cardPinChangeSteps.checkOtpEvoCardName();
        cardPinChangeSteps.setEvoCardOtp(dataControllerUserTransfer.getOtpInput());
        cardPinChangeSteps.checkChangePinMessage();
        cardPinChangeSteps.clickCloseNotificationButton();

    }
    @Test(priority = 8)
    public void cardSwitchedSteps(){
        cardSwitchedSteps.cardSwitchedToAnotherCard();
        cardSwitchedSteps.returnToEvoCard();

    }

   @Test(priority = 9)
    public void downloadingRequisitesSteps(){
        downloadingRequisitesSteps.clickDownloadButton();
        downloadingRequisitesSteps.checkFileExistence();

    }
    @Test(priority = 10)
    public void transferFromAccountSteps(){
        transferFromAccountSteps.transferButtonClick();
        transferFromAccountSteps.checkTransferHeader();


    }
    @Test(priority = 11)
    public void transferToOwnSteps(){
        transferToOwnSteps.clickTransferToOwnAccount();
        transferToOwnSteps.clickAccountTo();
        transferToOwnSteps.clickCurrentAccount();
        transferToOwnSteps.clickCurrencyGel();
        transferToOwnSteps.clickAmountInput();
        transferToOwnSteps.setEnterAmount(dataControllerAmountTransfer.getAmountTransfer());
        transferToOwnSteps.clickTransferButton();
        transferToOwnSteps.checkSuccessfulTransferPopup();

    }
    @Test(priority = 12)
    public void balanceValidationSteps(){
        balanceValidationSteps.validateBalanceChanges();
    }
}

