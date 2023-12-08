import java.awt.Frame;
import java.awt.Panel;
import java.awt.Button;

// 인터페이스 테스트
public class Test {
    public static void main(String[] args)
    {
        Frame f = new Frame();
        f.setTitle("frame");
        f.setBounds(100, 100, 300, 300);
        f.setVisible(true);

        Panel p = new Panel();
        Button btn = new Button("asdf");
        p.add(btn);

        f.add(p);
    }  
}
