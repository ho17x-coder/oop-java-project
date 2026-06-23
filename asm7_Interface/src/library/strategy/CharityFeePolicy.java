package library.strategy;
public class CharityFeePolicy implements LateFeePolicy {
    @Override
    public double applyPolicy(double baseFee) { return baseFee * 0.5; }
    @Override
    public String getPolicyName() { return "Tháng từ thiện — giảm 50%"; }
}
