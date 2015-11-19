package chat.rocket.network;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by julio on 19/11/15.
 */
public class RocketAPI {
    private Meteor mMeteor;

    public RocketAPI(Meteor meteor) {
        mMeteor = meteor;
    }

    public void addUserToRoom(String rid, String username, ResultListener listener) {
        Map<String, String> data = new HashMap<>();
        data.put("rid", rid);
        data.put("username", username);
        mMeteor.call("addUserToRoom", new Object[]{data}, listener);
    }

    public void archiveRoom(String rid, ResultListener listener) {
        mMeteor.call("archiveRoom", new Object[]{rid}, listener);
    }

    public void canAccessRoom(String rid, String userId, ResultListener listener) {
        mMeteor.call("archiveRoom", new Object[]{rid, userId}, listener);
    }

    public void channelsList(ResultListener listener) {
        mMeteor.call("channelsList", listener);
    }

    public void createChannel(String name, ResultListener listener) {
        mMeteor.call("createChannel", new Object[]{name, new short[]{}}, listener);
    }

    public void createDirectMessage(String username, ResultListener listener) {
        mMeteor.call("createDirectMessage", new Object[]{username}, listener);
    }

    public void createPrivateGroup(String name, ResultListener listener) {
        mMeteor.call("createPrivateGroup", new Object[]{name, new short[]{}}, listener);
    }

    public void deleteMessage(String id, ResultListener listener) {
        Map<String, String> data = new HashMap<>();
        data.put("_id", id);
        mMeteor.call("deleteMessage", new Object[]{data}, listener);
    }

    public void deleteUser(String userId, ResultListener listener) {
        mMeteor.call("deleteUser", new Object[]{userId}, listener);
    }

    public void eraseRoom(String rid, ResultListener listener) {
        mMeteor.call("eraseRoom", new Object[]{rid}, listener);
    }

    public void getAvatarSuggestion(ResultListener listener) {
        //TODO: How does it work???
    }

    public void getRoomIdByNameOrId(String rid, ResultListener listener) {
        mMeteor.call("getRoomIdByNameOrId", new Object[]{rid}, listener);
    }

    public void getTotalChannels(ResultListener listener) {
        mMeteor.call("getTotalChannels", listener);
    }

    public void getUsernameSuggestion(ResultListener listener) {
        //TODO: How does it work???
    }

    public void hideRoom(String rid, ResultListener listener) {
        mMeteor.call("hideRoom", new Object[]{rid}, listener);
    }

    public void joinRoom(String rid, ResultListener listener) {
        mMeteor.call("joinRoom", new Object[]{rid}, listener);
    }

    public void leaveRoom(String rid, ResultListener listener) {
        mMeteor.call("leaveRoom", new Object[]{rid}, listener);
    }

    public void loadHistory(String rid, long end, int limit, long ls, ResultListener listener) {
        //TODO: Not sure of what the end and ls parameters are...check it!
        mMeteor.call("loadHistory", new Object[]{rid}, listener);
    }

    public void loadLocale(String locale, ResultListener listener) {
        mMeteor.call("loadLocale", new Object[]{locale}, listener);
    }

    public void loadMissedMessages(String rid, long start, ResultListener listener) {
        mMeteor.call("loadMissedMessages", new Object[]{rid, start}, listener);
    }

    public void logoutCleanUp(ResultListener listener) {
        //TODO: How does it work???
    }

    public void messageSearch(String rid, String text, ResultListener listener) {
        mMeteor.call("messageSearch", new Object[]{text, rid}, listener);
    }

    public void migrate(ResultListener listener) {
        //TODO: How does it work???
    }

    public void openRoom(String rid, ResultListener listener) {
        mMeteor.call("openRoom", new Object[]{rid}, listener);
    }

    public void readMessages(String rid, ResultListener listener) {
        mMeteor.call("readMessages", new Object[]{rid}, listener);
    }

    public void registerUser(String name, String email, String pass, ResultListener listener) {
        Map<String, String> data = new HashMap<>();
        data.put("name", name);
        data.put("email", email);
        data.put("pass", pass);
        mMeteor.call("deleteMessage", new Object[]{data}, listener);
    }

    public void removeUserFromRoom(String rid, String username, ResultListener listener) {
        Map<String, String> data = new HashMap<>();
        data.put("rid", rid);
        data.put("username", username);
        mMeteor.call("removeUserFromRoom", new Object[]{data}, listener);
    }

    public void reportMessage(String message, String description, ResultListener listener) {
        //TODO: What it the message field? Just a string or must be the a message object?
        mMeteor.call("removeUserFromRoom", new Object[]{message, description}, listener);
    }

    public void resetAvatar(ResultListener listener) {
        //TODO: How does it work???
    }

    public void saveRoomName(String rid, String name, ResultListener listener) {
        mMeteor.call("saveRoomName", new Object[]{rid, name}, listener);
    }

    public void saveUserPreferences(boolean disableNewRoomNotification,
                                    boolean disableNewMessageNotification,
                                    boolean useEmojis,
                                    boolean convertAsciiEmoji,
                                    boolean saveMobileBandwidth,
                                    boolean compactView,
                                    boolean unreadRoomsMode,
                                    boolean autoImageLoad,
                                    ResultListener listener) {

        Map<String, String> data = new HashMap<>();

        data.put("disableNewRoomNotification", booleantoString(disableNewRoomNotification));
        data.put("disableNewMessageNotification", booleantoString(disableNewMessageNotification));
        data.put("useEmojis", booleantoString(useEmojis));
        data.put("convertAsciiEmoji", booleantoString(convertAsciiEmoji));
        data.put("saveMobileBandwidth", booleantoString(saveMobileBandwidth));
        data.put("compactView", booleantoString(compactView));
        data.put("unreadRoomsMode", booleantoString(unreadRoomsMode));
        data.put("autoImageLoad", booleantoString(autoImageLoad));

        mMeteor.call("saveUserPreferences", new Object[]{data}, listener);
    }

    private String booleantoString(boolean b) {
        return b ? "1" : "0";
    }

    public void saveUserProfile(String language, String realname, String username, ResultListener listener) {
        Map<String, String> data = new HashMap<>();

        data.put("language", language);
        data.put("realname", realname);
        data.put("username", username);

        mMeteor.call("saveUserProfile", new Object[]{data}, listener);
    }

    public void sendConfirmationEmail(String email, ResultListener listener) {
        mMeteor.call("sendConfirmationEmail", new Object[]{email}, listener);
    }

    public void sendForgotPasswordEmail(String email, ResultListener listener) {
        mMeteor.call("sendForgotPasswordEmail", new Object[]{email}, listener);
    }

    public void sendMessage(String rid, String msg, ResultListener listener) {
        Map<String, String> data = new HashMap<>();

        data.put("rid", rid);
        data.put("msg", msg);

        mMeteor.call("sendMessage", new Object[]{data}, listener);
    }

    public void setAvatarFromService(ResultListener listener) {
        //TODO: How does it work???
    }

    public void setUserActiveStatus(String userId, String active, ResultListener listener) {
        //TODO: Check what are the allowed values to active parameter
        mMeteor.call("setUserActiveStatus", new Object[]{userId, active}, listener);
    }

    public void toogleFavorite(ResultListener listener) {
        //TODO: How does it work???
    }

    public void unarchiveRoom(String rid, ResultListener listener) {
        mMeteor.call("unarchiveRoom", new Object[]{rid}, listener);
    }

    public void updateMessage(String msgId, String rid, String msg, ResultListener listener) {
        Map<String, String> data = new HashMap<>();

        data.put("_id", msgId);
        data.put("rid", rid);
        data.put("msg", msg);
        //TODO: check which fields to send!!

        mMeteor.call("updateMessage", new Object[]{data}, listener);
    }

    public void updateUserUtcOffset(ResultListener listener) {
        //TODO: How does it work???
    }
}
