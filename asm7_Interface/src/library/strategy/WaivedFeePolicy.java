package library.strategy;
public class WaivedFeePolicy implements LateFeePolicy {
    @Override
    public double applyPolicy(double baseFee) { return 0; }
    @Override
    public String getPolicyName() { return "Miễn phí Phạt (tháng khai trương)"; }
}
