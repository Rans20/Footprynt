import 'package:http/http.dart' as http;
import 'dart:convert';

Future<Map<String, dynamic>> getWeather(double lat, double lon, String apiKey) async {
  final url = 'https://api.openweathermap.org/data/2.5/weather?lat=$lat&lon=$lon&appid=$apiKey&units=metric';
  final response = await http.get(Uri.parse(url));
  if (response.statusCode == 200) {
    return jsonDecode(response.body);
  } else {
    throw Exception('Failed to load weather');
  }
}
