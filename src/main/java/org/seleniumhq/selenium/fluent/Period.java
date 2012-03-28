package org.seleniumhq.selenium.fluent;

import java.util.concurrent.TimeUnit;

public abstract class Period {

    public abstract int howLong();
    public abstract TimeUnit timeUnit();
    public abstract long getEndMillis(long from);

    public static class Seconds extends Period {
        private final int secs;

        public Seconds(int secs) {
            this.secs = secs;
        }

        @Override
        public int howLong() {
            return secs;
        }

        @Override
        public TimeUnit timeUnit() {
            return TimeUnit.SECONDS;
        }

        @Override
        public long getEndMillis(long from) {
            return from + (secs * 1000);
        }

        @Override
        public String toString() {
            return "secs(" + secs + ")";
        }
    }
    public static class Minutes extends Period {
        private final int mins;

        public Minutes(int mins) {
            this.mins = mins;
        }

        @Override
        public int howLong() {
            return mins;
        }

        @Override
        public TimeUnit timeUnit() {
            return TimeUnit.MINUTES;
        }

        @Override
        public long getEndMillis(long from) {
            return from + (mins * 1000 * 60);
        }

        @Override
        public String toString() {
            return "mins(" + mins + ")";
        }
    }

    public static class Milliseconds extends Period {
        private final int millis;

        public Milliseconds(int millis) {
            this.millis = millis;
        }

        @Override
        public int howLong() {
            return millis;
        }

        @Override
        public TimeUnit timeUnit() {
            return TimeUnit.MILLISECONDS;
        }

        @Override
        public long getEndMillis(long from) {
            return from + millis;
        }

        @Override
        public String toString() {
            return "millis(" + millis + ")";
        }
    }

    public static Period millis(int millis) {
        return new Milliseconds(millis);
    }

    public static Period secs(int secs) {
        return new Seconds(secs);
    }

    public static Period mins(int mins) {
        return new Minutes(mins);
    }


}
