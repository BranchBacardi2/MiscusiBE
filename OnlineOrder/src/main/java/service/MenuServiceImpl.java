package service;

import com.example.OnlineOrder.entity.Menu;
import com.example.OnlineOrder.entity.Piatti;
import com.example.OnlineOrder.entity.PiattoMenu;
import dao.MenuDaoImpl;
import dao.PiattiDaoImpl;
import dao.PiattoMenuDaoImpl;
import dto.MenuCreateDTO;
import dto.MenuResponseDTO;
import dto.PiattoMenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.castomExeption.NotFIndExeption;

import java.util.ArrayList;
import java.util.List;
@Service
public class MenuServiceImpl implements  MenuService {
    private MenuDaoImpl menuDao;
    private PiattoMenuDaoImpl piattoMenuDao;

    private PiattiDaoImpl piattiDao;
    @Autowired
    public MenuServiceImpl(MenuDaoImpl menuDao, PiattoMenuDaoImpl piattoMenuDao) {
        this.menuDao = menuDao;
        this.piattoMenuDao = piattoMenuDao;
        this.piattiDao = piattiDao;
    }


    private String controlPiattiNotExist ( List<PiattoMenuDTO> listId){
        StringBuilder result = new StringBuilder();
        for (PiattoMenuDTO piattoMenu : listId){
            Piatti piatto = piattiDao.findById(piattoMenu.getId_piatto());
            if (piatto == null){
                result.append(piattoMenu.getId_piatto()).append(" ");
            }
        }
        return result.toString();
    }
    @Override
    public MenuResponseDTO create(MenuCreateDTO menuInput) {

        String NotFindId = this.controlPiattiNotExist(menuInput.getPiatti());
        if (!NotFindId.isEmpty()){
            throw new NotFIndExeption("piatto",NotFindId );
        }

        MenuResponseDTO result = new MenuResponseDTO();

        Menu menu = new Menu();
        menu.setMenuId(0);
        menu.setAbilitato(menuInput.isAbilitato());
        menu.setNome(menuInput.getMenuName());
        Menu newMenu = menuDao.save(menu);
        result.setAbilitato(newMenu.getAbilitato());
        result.setMenuName(newMenu.getNome());
        result.setMenuId(newMenu.getMenuId());
        result.setDataCreazione(newMenu.getDataCreazione());

        List<PiattoMenu> piattiMenu = new ArrayList<PiattoMenu>();
        for ( PiattoMenuDTO piattoMenuDTO : menuInput.getPiatti()) {
               PiattoMenu piattoMenu  = new PiattoMenu();
               piattoMenu.setMenu(newMenu);
               Piatti piatto = new  Piatti();
               piatto.setPiattoId(piattoMenuDTO.getId_piatto());
               piattoMenu.setPiatto( piatto);
               piattiMenu.add(piattoMenu);
        }
        List<PiattoMenu> newPiattiMenu = piattoMenuDao.saveAll(piattiMenu);

        for ( PiattoMenu newPiattoMenu :newPiattiMenu ) {
              PiattoMenuDTO piattoMenuDTO = new PiattoMenuDTO();
              piattoMenuDTO.setId_piatto(newPiattoMenu.getPiatto().getPiattoId());
              piattoMenuDTO.setNomePiatto(newPiattoMenu.getPiatto().getDescrizione());
              result.addPiatto(piattoMenuDTO);
        }

        return  result;
    }

    @Override
    public MenuCreateDTO update(MenuCreateDTO menuInput) {
        return null;
    }
}
