package  ma.sqli.formation.ws.converter.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sqli.formation.ws.converter.client.ClientCategoryConverter;



import ma.sqli.formation.zynerator.util.StringUtil;
import ma.sqli.formation.zynerator.converter.AbstractConverter;
import ma.sqli.formation.zynerator.util.DateUtil;
import ma.sqli.formation.bean.core.client.Client;
import ma.sqli.formation.ws.dto.client.ClientDto;

@Component
public class ClientConverter extends AbstractConverter<Client, ClientDto> {

    @Autowired
    private ClientCategoryConverter clientCategoryConverter ;
    private boolean clientCategory;

    public  ClientConverter(){
        super(Client.class, ClientDto.class);
    }

    @Override
    public Client toItem(ClientDto dto) {
        if (dto == null) {
            return null;
        } else {
        Client item = new Client();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(this.clientCategory && dto.getClientCategory()!=null &&  dto.getClientCategory().getId() != null)
                item.setClientCategory(clientCategoryConverter.toItem(dto.getClientCategory())) ;




        return item;
        }
    }

    @Override
    public ClientDto toDto(Client item) {
        if (item == null) {
            return null;
        } else {
            ClientDto dto = new ClientDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
        if(this.clientCategory && item.getClientCategory()!=null) {
            dto.setClientCategory(clientCategoryConverter.toDto(item.getClientCategory())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.clientCategory = value;
    }


    public ClientCategoryConverter getClientCategoryConverter(){
        return this.clientCategoryConverter;
    }
    public void setClientCategoryConverter(ClientCategoryConverter clientCategoryConverter ){
        this.clientCategoryConverter = clientCategoryConverter;
    }
    public boolean  isClientCategory(){
        return this.clientCategory;
    }
    public void  setClientCategory(boolean clientCategory){
        this.clientCategory = clientCategory;
    }
}
