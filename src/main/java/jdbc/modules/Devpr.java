package jdbc.modules;

public class Devpr {

    private int devId;
    private int devprId;
    private int projId;


        public int getDevId() {
            return devId;
        }

        public void setDevId(int devId) {
            this.devId = devId;
        }

        public int getDevprId() {
            return devprId;
        }

        public void setDevprId(int devprId) {
            this.devprId = devprId;
        }

        public int getProjId() {
            return projId;
        }

        public void setProjId(int projId) {
            this.projId = projId;
        }

        @Override
        public String toString() {
            return "DEVPR{" +
                    "devId=" + devId +
                    ", devprId=" + devprId +
                    ", projId=" + projId +
                    '}';
        }
}

