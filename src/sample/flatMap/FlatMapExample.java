package sample.flatMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FlatMapExample {

    static class Room {
        String roomType;
        Long count;

        public Room(String roomType, Long count) {
            this.roomType = roomType;
            this.count = count;
        }
    }

    static class Hotel {
        String name;
        Set<Room> rooms = new HashSet<>();

        public Hotel(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {

        Hotel hotel1 = new Hotel("H1");
        Room room1 = new Room("H1_Single", 5l);
        Room room2 = new Room("H1_Double", 4l);
        hotel1.rooms.add(room1);
        hotel1.rooms.add(room2);

        Hotel hotel2 = new Hotel("H2");
        Room room3 = new Room("H2_Single", 5l);
        Room room4 = new Room("H2_Double", 4l);
        hotel2.rooms.add(room3);
        hotel2.rooms.add(room4);

        List<Hotel> hotels = new ArrayList<>();
        hotels.add(hotel1);
        hotels.add(hotel2);

        Supplier<Stream<Set<Room>>> roomsSupplier = () -> hotels.stream().map(x -> x.rooms);

        //        Stream<Set<Room>> rooms = hotels.stream().map(x -> x.rooms); //.forEach(System.out::println);

        // Without flatMap
        Stream<Stream<Room>> mappedObject = roomsSupplier.get().map(x -> x.stream());
        mappedObject.forEach(roomStream -> roomStream.map(x -> x.roomType).forEach(System.out::println));

        System.out.println(" ");

        // With flatMap
        Stream<Room> flatMappedObject = roomsSupplier.get().flatMap(x -> x.stream());
        flatMappedObject.map(x -> x.roomType).forEach(System.out::println);



    }

}
