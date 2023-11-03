package  ma.sqli.formation.ws.converter.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.sqli.formation.zynerator.util.StringUtil;
import ma.sqli.formation.zynerator.converter.AbstractConverter;
import ma.sqli.formation.zynerator.util.DateUtil;
import ma.sqli.formation.bean.core.client.ClientCategory;
import ma.sqli.formation.ws.dto.client.ClientCategoryDto;

@Component
public class ClientCategoryConverter extends AbstractConverter<ClientCategory, ClientCategoryDto> {


    public  ClientCategoryConverter(){
        super(ClientCategory.class, ClientCategoryDto.class);
    }

    @Override
    public ClientCategory toItem(ClientCategoryDto dto) {
        if (dto == null) {
            return null;
        } else {
        ClientCategory item = new ClientCategory();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());



        return item;
        }
    }

    @Override
    public ClientCategoryDto toDto(ClientCategory item) {
        if (item == null) {
            return null;
        } else {
            ClientCategoryDto dto = new ClientCategoryDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
