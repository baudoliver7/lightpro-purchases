package com.lightpro.purchases.rs;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.Callable;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lightpro.purchases.vm.PurchasesVm;
import com.securities.api.Module;
import com.securities.api.ModuleType;
import com.securities.api.Secured;

@Path("/purchases/module")
public class PurchasesModuleRs extends PurchasesBaseRs {
	
	@GET
	@Secured
	@Path("/current")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getCurrent(@PathParam("id") UUID id) throws IOException {	
		
		return createHttpResponse(
				new Callable<Response>(){
					@Override
					public Response call() throws IOException {
						
						PurchasesVm item = new PurchasesVm(purchases());

						return Response.ok(item).build();
					}
				});		
	}
	
	@POST
	@Secured
	@Path("/install")
	@Produces({MediaType.APPLICATION_JSON})
	public Response installModule() throws IOException {
		
		return createHttpResponse(
				new Callable<Response>(){
					@Override
					public Response call() throws IOException {
											
						Module purchases = purchases(currentCompany().modulesSubscribed().get(ModuleType.PURCHASES));					
						purchases.install();
						
						return Response.status(Response.Status.OK).build();	
					}
				});					
	}
	
	@POST
	@Secured
	@Path("/uninstall")
	@Produces({MediaType.APPLICATION_JSON})
	public Response uninstallModule() throws IOException {
		
		return createHttpResponse(
				new Callable<Response>(){
					@Override
					public Response call() throws IOException {
											
						purchases().uninstall();
						
						return Response.status(Response.Status.OK).build();
					}
				});			
	}
}
