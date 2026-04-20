class CarbonService {
  // Emission factors in grams per km
  static const double drivingEmissionFactor = 120.0;
  static const double walkingEmissionFactor = 0.0;

  double calculateCO2(double distanceInKm, String mode) {
    if (mode == 'driving') {
      return distanceInKm * drivingEmissionFactor;
    } else {
      return distanceInKm * walkingEmissionFactor;
    }
  }

  String getRecommendation(double drivingCO2, double walkingCO2) {
    double savings = drivingCO2 - walkingCO2;
    if (savings > 0) {
      return "By walking, you save ${savings.toStringAsFixed(2)}g of CO2!";
    }
    return "Great job staying green!";
  }
}
