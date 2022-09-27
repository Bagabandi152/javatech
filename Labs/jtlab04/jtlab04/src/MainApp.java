public class MainApp {
    MainApp(){
        try {
            problem01();
        }catch (CloneNotSupportedException ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MainApp();
    }

    void problem01() throws CloneNotSupportedException {
        Octagon o1 = new Octagon(5);
        Octagon o2 = (Octagon) o1.clone();

        System.out.println("Хариу: " + (o1.compareTo(o2) > 0 ?  "Их" : o1.compareTo(o2) > 0 ? "Бага" : "Тэнцүү"));
    }
}
