package br.com.uds.pizzariaapi.repository.helper.pedido;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.uds.pizzariaapi.model.Pedido;
import br.com.uds.pizzariaapi.model.Pizza;

public class PedidosImpl implements PedidosQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public Pedido buscarPorId(Long id) {
		CriteriaBuilder builder = this.manager.getCriteriaBuilder();
		CriteriaQuery<Pedido> criteria = builder.createQuery(Pedido.class);
		Root<Pedido> root = criteria.from(Pedido.class);
		
		Join<Pizza, Pedido> pizza = (Join) root.fetch("pizza", JoinType.LEFT);
		
		List<Predicate> predicates = new ArrayList<Predicate>();	
		
		if (id != null) {
			predicates.add(builder.equal(root.<Long>get("id"), id));
		}
		
		criteria.where(predicates.toArray(new Predicate[predicates.size()]));
		
		TypedQuery<Pedido> query = this.manager.createQuery(criteria);
		return query.getSingleResult();
	}
}
