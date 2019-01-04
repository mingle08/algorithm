package algo.jdk.statePattern;

public class OpenningState extends LiftState {

    @Override
    public void open() {
        System.out.println("电梯门开启……");
    }

    @Override
    public void close() {
        //状态修改
        context.setLiftState(Context.closingState);
        // 动作委托给closingState来执行
        context.getLiftState().close();
    }

    @Override
    public void run() {
        // do nothing
    }

    @Override
    public void stop() {
        // do nothing

    }

}
