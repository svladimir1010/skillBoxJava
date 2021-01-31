import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AllRouteCalculatorTest extends TestCase {
    StationIndex stationIndex;
    RouteCalculator routeCalculator;

    @Override
    protected void setUp() throws Exception {
        stationIndex = new StationIndex();
        routeCalculator = new RouteCalculator(stationIndex);

        List<Line> lines = new ArrayList<Line>() {{
            add(new Line(1, "First"));
            add(new Line(2, "Second"));
            add(new Line(3, "Third"));
        }};

        lines.forEach(e -> stationIndex.addLine(e));

        List<Station> stations = new ArrayList<Station>() {{
            add(new Station("Главная", stationIndex.getLine(1)));
            add(new Station("Вторая", stationIndex.getLine(1)));
            add(new Station("Третья", stationIndex.getLine(1)));
            add(new Station("Четвертая", stationIndex.getLine(1)));
            add(new Station("Пятая", stationIndex.getLine(1)));
            add(new Station("Шестая", stationIndex.getLine(2)));
            add(new Station("Восьмая", stationIndex.getLine(2)));
            add(new Station("Девятая", stationIndex.getLine(2)));
            add(new Station("Десятая", stationIndex.getLine(2)));
            add(new Station("Одиннадцатая", stationIndex.getLine(2)));
            add(new Station("Двенадцатая", stationIndex.getLine(3)));
            add(new Station("Тренадцатая", stationIndex.getLine(3)));
            add(new Station("Четырнадцатая", stationIndex.getLine(3)));
            add(new Station("Пятнадцатая", stationIndex.getLine(3)));
            add(new Station("Шестнадцатая", stationIndex.getLine(3)));

        }};


        for (Station station : stations) {
            if (station.getLine().equals(stationIndex.getLine(1))) {
                stationIndex.getLine(1).addStation(station);
            }
            if (station.getLine().equals(stationIndex.getLine(2))) {
                stationIndex.getLine(2).addStation(station);
            }
            if (station.getLine().equals(stationIndex.getLine(3))) {
                stationIndex.getLine(3).addStation(station);
            }
        }

        for (Station station : stations) {
            stationIndex.addStation(station);
        }

        List<Station> connections1 = new ArrayList<Station>() {{
            add(stationIndex.getStation("Четвертая"));
            add(stationIndex.getStation("Двенадцатая"));
        }};

        List<Station> connections2 = new ArrayList<Station>() {{
            add(stationIndex.getStation("Девятая"));
            add(stationIndex.getStation("Пятнадцатая"));
        }};

        stationIndex.addConnection(connections1);
        stationIndex.addConnection(connections2);

    }

    //    @Test
    public void test_distance_to_same_station() {
        List<Station> actualStations = routeCalculator.getShortestRoute(stationIndex.getStation("Главная"), stationIndex.getStation("Третья"));
        List<Station> expectedStations = buildRoute("Главная -> Вторая -> Третья");
        assertEquals(expectedStations, actualStations);
    }

    public void test_stations_next_to_each_other_on_single_line() {
        List<Station> actualStations = routeCalculator.getShortestRoute(stationIndex.getStation("Вторая"),
                stationIndex.getStation("Пятая"));
        List<Station> expectedStations = buildRoute("Вторая -> Третья -> Четвертая -> Пятая");
        assertEquals(expectedStations, actualStations);
    }

    public void test_stations_reverse_to_each_other_on_single_line() {
        List<Station> actualStations = routeCalculator.getShortestRoute(stationIndex.getStation("Третья"),
                stationIndex.getStation("Главная"));
        List<Station> expectedStations = buildRoute("Третья -> Вторая -> Главная");
        assertEquals(expectedStations, actualStations);
    }

    public void test_opposite_station_on_single_line() {
        List<Station> actualStations = routeCalculator.getShortestRoute(stationIndex.getStation("Главная"),
                stationIndex.getStation("Двенадцатая"));
        List<Station> expectedStations = buildRoute("Главная -> Вторая -> Третья -> " +
                "Четвертая ->  Двенадцатая");
        assertEquals(expectedStations, actualStations);
    }

    public void test_opposite_station_wit_one_transfer() {
        List<Station> actualStations = routeCalculator.getShortestRoute(stationIndex.getStation("Главная"),
                stationIndex.getStation("Тренадцатая"));
        List<Station> expectedStations = buildRoute("Главная -> Вторая -> Третья -> " +
                " Четвертая ->  Двенадцатая -> Тренадцатая");
        assertEquals(expectedStations, actualStations);
    }

    public void test_opposite_station_wit_two_transfers() {
        List<Station> actualStations = routeCalculator.getShortestRoute(stationIndex.getStation("Главная"),
                stationIndex.getStation("Десятая"));
        List<Station> expectedStations = buildRoute("Главная -> Вторая -> Третья -> Четвертая " +
                " -> Двенадцатая -> Тренадцатая -> Четырнадцатая -> Пятнадцатая -> Девятая -> Десятая");
        assertEquals(expectedStations, actualStations);
    }

    public void test_calc_duration_with_two_transfers_22() {
        double actualTime = RouteCalculator.calculateDuration(buildRoute("Главная -> Вторая -> Третья -> Четвертая -> Двенадцатая -> Тренадцатая -> Четырнадцатая -> Пятнадцатая -> Девятая -> Десятая"));
        double expectedTime = 24.5;
        assertEquals(expectedTime, actualTime);
    }


    private List<Station> buildRoute(String str) {
        String[] stations = str.split(" -+> ");
        return Arrays.stream(stations).map(s -> stationIndex.getStation(s.trim()))
                .collect(Collectors.toList());
    }

}
