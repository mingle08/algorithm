package jdk.statePattern;

public class RunningState extends LiftState {

    // 电梯运行中，不可能开门
    @Override
    public void open() {
        
    }

    // 电梯门关闭，这是必须的
    @Override
    public void close() {
        

    }
    //这是在运行状态下要实现的方法
    @Override
    public void run() {
        System.out.println("电梯在行进中");

    }

    @Override
    public void stop() {
        context.setLiftState(Context.stoppingState);
        context.getLiftState().stop();

    }

}
