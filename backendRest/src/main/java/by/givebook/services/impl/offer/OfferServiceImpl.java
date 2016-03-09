package by.givebook.services.impl.offer;

import by.givebook.dto.offer.OfferDTO;
import by.givebook.entities.library.Author;
import by.givebook.entities.offer.Offer;
import by.givebook.repositories.library.AuthorRepository;
import by.givebook.repositories.library.WorkRepository;
import by.givebook.services.impl.SimpleServiceImpl;
import by.givebook.services.offer.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by FruityDevil on 05.03.2016.
 */
@Service
public class OfferServiceImpl extends SimpleServiceImpl<Offer> implements OfferService {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private WorkRepository workRepository;

    @Override
    public void save(OfferDTO offerDTO) {
//        Object author = authorRepository.existsWithName(offerDTO.getOfferBookDTO().getLastName(),
//                offerDTO.getOfferBookDTO().getFirstName(),
//                offerDTO.getOfferBookDTO().getMiddleName());
//        if (author == null) {
//            author = new Author();
//            authorRepository.save((Author)author);
//        }
    }
}
