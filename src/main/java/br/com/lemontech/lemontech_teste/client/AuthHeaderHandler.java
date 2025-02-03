package br.com.lemontech.lemontech_teste.client;


import javax.xml.namespace.QName;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.soap.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import java.util.Set;

public class AuthHeaderHandler implements SOAPHandler<SOAPMessageContext>{

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean outbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (outbound){
            try {
                SOAPEnvelope envelope = context.getMessage().getSOAPPart().getEnvelope();
                SOAPHeader header = envelope.getHeader();
                if (header == null) header = envelope.addHeader();

                String namespace = "http://lemontech.com.br/selfbooking/wsselfbooking/services";
                SOAPHeaderElement authHeader = header.addHeaderElement(new QName(namespace, "Header"));

                SOAPElement userPassword = authHeader.addChildElement("userPassword", "ser");
                userPassword.addTextNode("3970f1cebb81d3bc5b3e232051c2d9ec");

                SOAPElement keyClient = authHeader.addChildElement("keyClient", "ser");
                keyClient.addTextNode("projetos_lemontech_qa");

            } catch (SOAPException e) {
                throw new RuntimeException("Falha ao adicionar header de autenticação", e);
            }
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) {
    }

    @Override
    public Set<QName> getHeaders() {
        return null;
    }
}
