package com.example.lizan.eventBus;

public class Cons {

    public static final String EXCHANGE = "ZMeet";

    /**
     * 直播中接收会议消息的广播类型exchange
     */
    public static final String LIVE_CHAT_FANOUT_EXCHANGE = "LiveChatFanout";

    /**
     * 信令
     */
    public static final String SIGNAL_FANOUT_EXCHANGE = "SignalFanout";

    /**
     * MediaServer
     */
    public static final String MEDIA_SERVER_FANOUT_EXCHANGE = "MediaServerFanout";

    public static final String ENVELOPE = "envelope";
    public static final String CORE = "core";
    public static final String HEAD = "header";
    public static final String BODY = "body";

    public final static String AKKA_DL_CHANNEL = "apps-server-dl";
    public final static String CONTROLLER_DL_CHANNEL = "controller-server-dl";
    public final static String CONVERT_DL_CHANNEL = "convert-server-dl";
    public final static String FS_DL_CHANNEL = "fs-server-dl";

    public static final String DOCUMENT_CONVERT_CHANNEL = "to-document-convert";
    public static final String FROM_DOCUMENT_CONVERT_CHANNEL = "from-document-convert";
}
