package study.statePattern;

public class Context {

    public static final OpenningState openningState = new OpenningState();
    public static final ClosingState closingState = new ClosingState();
    public static final RunningState runningState = new RunningState();
    public static final StoppingState stoppingState = new StoppingState();
    
    private LiftState liftState;

    public LiftState getLiftState() {
        return liftState;
    }

    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
        //
        liftState.setContext(this);
    }
    
    public void open(){
        liftState.open();
    }
    
    public void close(){
        liftState.close();
    }
    
    public void run(){
        liftState.run();
    }
    
    public void stop(){
        liftState.stop();
    }
}
