public interface Callable {
    void powerOn(); //утсаа асаах
    void dial(int phoneNumber); //дугаар луу залгах
    void answer(); //дуудлагад хариу өгөх
    boolean callPhone(int phoneNumber); //өгөгдсөндугаар луу залгагдаж буй эсэх
    boolean isRinging(); //утас дуугарч байгаа эсэх
}
