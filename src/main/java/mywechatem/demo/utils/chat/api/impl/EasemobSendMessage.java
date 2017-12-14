package mywechatem.demo.utils.chat.api.impl;


import io.swagger.client.ApiException;
import io.swagger.client.api.MessagesApi;
import io.swagger.client.model.Msg;
import mywechatem.demo.utils.chat.api.SendMessageAPI;
import mywechatem.demo.utils.chat.comm.EasemobAPI;
import mywechatem.demo.utils.chat.comm.OrgInfo;
import mywechatem.demo.utils.chat.comm.ResponseHandler;
import mywechatem.demo.utils.chat.comm.TokenUtil;

public class EasemobSendMessage implements SendMessageAPI {
    private ResponseHandler responseHandler = new ResponseHandler();
    private MessagesApi api = new MessagesApi();
    @Override
    public Object sendMessage(final Object payload) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameMessagesPost(OrgInfo.ORG_NAME,OrgInfo.APP_NAME, TokenUtil.getAccessToken(), (Msg) payload);
            }
        });
    }
}
