package com.example.li.myrxandroid.model.entity;

import java.util.List;

public class WeatherBean {

    /**
     * code : 200
     * msg : 成功!
     * data : {"yesterday":{"date":"14日星期五","high":"高温 7℃","fx":"
     *         无持续风向","low":"低温 4℃","fl":"","type":"阴"},"city":"成都",
     *         "aqi":"89",
     *         "forecast":[{"date":"15日星期六","high":"高温 10℃","fengli":"","low":"低温 2℃","fengxiang":"无持续风向","type":"多云"},
     *                     {"date":"16日星期天","high":"高温 15℃","fengli":"","low":"低温 3℃","fengxiang":"无持续风向","type":"晴"},
     *                     {"date":"17日星期一","high":"高温 14℃","fengli":"","low":"低温 5℃","fengxiang":"无持续风向","type":"晴"},
     *                     {"date":"18日星期二","high":"高温 11℃","fengli":"","low":"低温 6℃","fengxiang":"无持续风向","type":"多云"},
     *                     {"date":"19日星期三","high":"高温 12℃","fengli":"","low":"低温 6℃","fengxiang":"无持续风向","type":"多云"}],
     *       "ganmao":"昼夜温差较大，较易发生感冒，请适当增减衣服。体质较弱的朋友请注意防护。","wendu":"9"}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * yesterday : {"date":"14日星期五","high":"高温 7℃","fx":"无持续风向","low":"低温 4℃","fl":"","type":"阴"}
         * city : 成都
         * aqi : 89
         * forecast : [{"date":"15日星期六","high":"高温 10℃","fengli":"","low":"低温 2℃","fengxiang":"无持续风向","type":"多云"},{"date":"16日星期天","high":"高温 15℃","fengli":"","low":"低温 3℃","fengxiang":"无持续风向","type":"晴"},{"date":"17日星期一","high":"高温 14℃","fengli":"","low":"低温 5℃","fengxiang":"无持续风向","type":"晴"},{"date":"18日星期二","high":"高温 11℃","fengli":"","low":"低温 6℃","fengxiang":"无持续风向","type":"多云"},{"date":"19日星期三","high":"高温 12℃","fengli":"","low":"低温 6℃","fengxiang":"无持续风向","type":"多云"}]
         * ganmao : 昼夜温差较大，较易发生感冒，请适当增减衣服。体质较弱的朋友请注意防护。
         * wendu : 9
         */

        private YesterdayBean yesterday;
        private String city;
        private String aqi;
        private String ganmao;
        private String wendu;
        private List<ForecastBean> forecast;

        @Override
        public String toString() {
            return "城市：" + city
                    + "\n实时温度：" + wendu
                    +"\n天气：" +  forecast.get(0).type
                    + "\n日期：" + forecast.get(0).date
                    + "\n最高温度：" + forecast.get(0).high
                    + "    最低温度：" + forecast.get(0).low;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAqi() {
            return aqi;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            /**
             * date : 14日星期五
             * high : 高温 7℃
             * fx : 无持续风向
             * low : 低温 4℃
             * fl :
             * type : 阴
             */

            private String date;
            private String high;
            private String fx;
            private String low;
            private String fl;
            private String type;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class ForecastBean {
            /**
             * date : 15日星期六
             * high : 高温 10℃
             * fengli :
             * low : 低温 2℃
             * fengxiang : 无持续风向
             * type : 多云
             */

            private String date;
            private String high;
            private String fengli;
            private String low;
            private String fengxiang;
            private String type;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getFengli() {
                return fengli;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getFengxiang() {
                return fengxiang;
            }

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
