package hw.ch16;

import java.awt.Label;
import java.awt.Color;

public class ColleagueLabel extends Label implements Colleague {
    // Mediator를 저장한다
    private Mediator mediator;
    // 생성자에서 caption을 지정한다
   public ColleagueLabel(String caption) {
        super(caption);
    }
    // Mediator를 설정한다
    @Override
    public void setMediator(Mediator mediator){
        this.mediator = mediator;
    }
    // Mediator에서 활성/비활성을 지시한다
    @Override
    public void setColleagueEnabled (boolean enabled){
        if( enabled){
            setText("● 로그인 가능");
            setForeground(Color.blue);  
        }else{
            setText("● 로그인 불가");
            setForeground(Color.gray);
        }
    }
}
