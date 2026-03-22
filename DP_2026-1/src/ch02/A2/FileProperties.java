package ch02.A2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

//어댑터
public class FileProperties implements FileIO {
    Properties property = new Properties(); //어댑터를 속성으로 가지고 있음

    @Override
    public void readFromFile(String filename) throws IOException {
        property.load(new FileReader(filename));//어댑터에게 위임
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        property.store(new FileWriter(filename), "written by FileProperties"); //어댑터에게 위임
    }

    @Override
    public void setValue(String key, String value) {
        property.setProperty(key, value); //어댑터에게 위임
    }

    @Override
    public String getValue(String key) {
        return property.getProperty(key, ""); //어댑터에게 위임, 키가 존재하지 않을 때는 빈 문자열 반환
    }
}
