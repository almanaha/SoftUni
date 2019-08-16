package Q_Exams.RetakeExam15August2019.spaceStation;

import Q_Exams.RetakeExam15August2019.spaceStation.core.Controller;
import Q_Exams.RetakeExam15August2019.spaceStation.core.ControllerImpl;
import Q_Exams.RetakeExam15August2019.spaceStation.core.Engine;
import Q_Exams.RetakeExam15August2019.spaceStation.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
