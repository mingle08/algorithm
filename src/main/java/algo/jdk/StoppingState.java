package study.statePattern;

public class StoppingState extends LiftState {

    // 停止状态要开门，这是正常的
    @Override
    public void open() {
        context.setLiftState(Context.openningState);
        context.getLiftState().open();
    }

    // 停止状态，电梯门本来就是关闭的
    @Override
    public void close() {
        

    }

    // 停止状态再跑起来，正常得很
    @Override
    public void run() {
        context.setLiftState(Context.runningState);
        context.getLiftState().run();

    }

    @Override
    public void stop() {
        System.out.println("电梯停止了");

    }

}
