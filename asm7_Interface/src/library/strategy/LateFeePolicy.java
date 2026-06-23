package library.strategy;
public interface LateFeePolicy {
    double applyPolicy(double baseFee);
    String getPolicyName();
}
