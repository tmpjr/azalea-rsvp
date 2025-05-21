FROM amazoncorretto:17


COPY . /usr/local/rsvp
WORKDIR /usr/local/rsvp
RUN ./gradlew build

