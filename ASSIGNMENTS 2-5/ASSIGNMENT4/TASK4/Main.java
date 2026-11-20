import javax.swing.*;import java.awt.*;
public class Main {
 public static void main(String[] args){
  JPanel root=new JPanel(new BorderLayout(8,8));
  JPanel search=new JPanel(new FlowLayout(FlowLayout.LEFT));search.add(new JTextField(18));search.add(new JComboBox<>(new String[]{"All","Java","Networks"}));search.add(new JButton("Search"));
  JTextArea results=new JTextArea("Search results appear here");JPanel buttons=new JPanel(new FlowLayout());buttons.add(new JButton("Prev"));buttons.add(new JButton("Next"));buttons.add(new JButton("Reserve"));
  root.add(new JLabel("Campus Library",SwingConstants.CENTER),BorderLayout.NORTH);root.add(search,BorderLayout.PAGE_START);root.add(new JScrollPane(results),BorderLayout.CENTER);root.add(buttons,BorderLayout.SOUTH);
  System.out.println("Layout configured: BorderLayout root, FlowLayout search/actions, scrollable results.");
  System.out.println("Resize rule: centre results area receives remaining space.");
 }
}
