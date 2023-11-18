package SwagLabsTest.config;

import org.aeonbits.owner.Config;

    @Config.Sources({
            "classpath:${environment}.properties",
    })

    public interface WebConfig extends Config {

        @Key("browser")
        @DefaultValue("CHROME")
        Browser getBrowser();


        @Key("browserVersion")
        @DefaultValue("116.0")
        String getBrowserVersion();

        @Config.Key("browserSize")
        @DefaultValue("1920x1080")
        String getBrowserSize();

        @Key("webUrl")
        @DefaultValue("https://www.saucedemo.com/")
        String getBaseUrl();

        @Key("isRemote")
        @DefaultValue("true")
        Boolean isRemote();

        @Key("remoteUrl")
        String getRemoteUrl();
}
