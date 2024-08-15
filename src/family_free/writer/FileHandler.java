package family_free.writer;

import family_free.FamilyTree.FamilyTree;
import family_free.human.Human;

import java.io.*;

public class FileHandler implements Writer {
    private String filePath;

    public void setPath(String filePath) {
        this.filePath = filePath;
    }

    @Override //- зачем это тут, а главное для чего?
    //почему на семенаре в аналогичном методе в аргументах было Serializable serializable?
    // я не очень понимаю как тут привязать этот интерфейс
    public void write(Object human){
        try(ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("src/family_free/writer/people.bin"))) {
            file.writeObject(human);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override //- зачем это тут, а главное для чего?
    public Object read() {
        try(ObjectInputStream file = new ObjectInputStream(new FileInputStream("src/family_free/writer/people.bin"))) {
            Object human = (Object) file.readObject();
            return human;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
