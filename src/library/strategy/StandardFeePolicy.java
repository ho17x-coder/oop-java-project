package library.strategy;
public class StandardFeePolicy implements LateFeePolicy {
    @Override
    public double applyPolicy(double baseFee) { return baseFee; }
    @Override
    public String getPolicyName() { return "Phí phạt tiêu chuẩn (100%)"; }
}
