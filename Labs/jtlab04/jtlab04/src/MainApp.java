import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    MainApp(){
        try {
            problem01();
        }catch (CloneNotSupportedException ex){
            ex.printStackTrace();
        }

        problem02();
    }

    public static void main(String[] args) {
        new MainApp();
    }

    void problem01() throws CloneNotSupportedException {
        Octagon o1 = new Octagon(5);
        Octagon o2 = (Octagon) o1.clone();

        System.out.println("Хариу: " + (o1.compareTo(o2) > 0 ?  "Их" : o1.compareTo(o2) > 0 ? "Бага" : "Тэнцүү"));
    }

    void problem02(){
        ArrayList<GeometricObject> geoArr = new ArrayList<>(
                List.of(new GeometricObject[]{
                        new Triangle(2, 3, 6),
                        new Square(2),
                        new Rectangle(2, 3),
                        new Square(3),
                        new Circle(2),
                        new Octagon(5),
                })
        );

        for(int i = 0; i < geoArr.size(); i++){
            if(geoArr.get(i) instanceof Colorable){
                ((Colorable) geoArr.get(i)).howToColor();
            }
        }
    }
}
