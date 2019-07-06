package commerce.ServiceInterface;

import java.util.List;

import baseService.baseUCService;
import commerce.Entity.Brandcat;

public interface BrandcatUCService extends baseUCService<Brandcat> {

	public List<Brandcat> DISTINCTShow();
}
