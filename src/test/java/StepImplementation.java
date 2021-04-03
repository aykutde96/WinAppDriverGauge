import com.thoughtworks.gauge.Step;
import io.testinium.base.BasePage;
import org.apache.commons.mail.EmailException;
import java.util.concurrent.TimeUnit;


public class StepImplementation {
    private BasePage basePage;
    public StepImplementation(){basePage=new BasePage();}

    @Step("<key> elementine tıklandı")
    public void clickElement(String key) throws InterruptedException{
      basePage.clickElementByName(key);
    }
    @Step("<key> saniye bekle")
    public void timeUnitSeconds(int key) {
        try {
            TimeUnit.SECONDS.sleep(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Step("<key> yazıldı")
    public void writeSomething(String key) throws InterruptedException {
        basePage.ekranaYaziYaz(key);

    }
    @Step("Alt satıra geç")
    public void keysEnter(){
        basePage.enterPress();

    }
    @Step("Dosyaya <key> adı verildi")
    public void saveFile(String key) throws InterruptedException {
        basePage.fileName(key);

    }
    @Step("Mail Gönderildi")
    public void sendingMail() throws EmailException {
        basePage.sendMail();
    }
    @Step("Tarih Yazdırıldı")
    public void writeDate() {
        basePage.writeDate();
    }

    @Step("içerik temizlendi")
    public void cleanEditPart() throws InterruptedException {
        basePage.cleanEdit();
    }


}
