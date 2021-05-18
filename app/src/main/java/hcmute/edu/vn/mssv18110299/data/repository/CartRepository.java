package hcmute.edu.vn.mssv18110299.data.repository;

import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.mssv18110299.data.Cart;
import hcmute.edu.vn.mssv18110299.data.CartItem;
import hcmute.edu.vn.mssv18110299.data.Item;
import hcmute.edu.vn.mssv18110299.data.MiniMarketDatabase;
import hcmute.edu.vn.mssv18110299.data.MiniMarketDatabaseApplication;
import hcmute.edu.vn.mssv18110299.data.User;
import hcmute.edu.vn.mssv18110299.data.dao.CartDao;
import hcmute.edu.vn.mssv18110299.data.model.ResponseModel;
import hcmute.edu.vn.mssv18110299.utilities.Session;

public class CartRepository {

    private MiniMarketDatabase db;
    public CartRepository(){
        db = MiniMarketDatabaseApplication.GetDatabase();

    }

    public ArrayList<CartItem> GetCartUser(String email)
    {
        User user = db.userDao().GetUser(email);
        // check user exits
        if(user!= null){
            List<CartItem> cartItemList = db.cartItemDao().GetCartItemsById(user.getId());

            cartItemList.forEach(c -> c.setItem(db.itemDao().GetItem(c.getItemId())));

            return new ArrayList<>(cartItemList);
        }
        return new ArrayList<>();
    }

    public ResponseModel addToCart(CartItem cartItem)
    {
        try {
            db.cartItemDao().AddCartItem(cartItem);
            return new ResponseModel(true,"Add to Cart Success");
        }
        catch (Exception ex){
            return new ResponseModel(false,ex.getMessage());
        }

    }
    public ResponseModel addToCart(String userName, Item item)
    {
        try {
           int userid = db.userDao().GetUser(userName).getId();
           db.cartItemDao().AddCartItem(new CartItem(item.getId(),userid,1));
            return new ResponseModel(true,"Add to Cart Success");
        }
        catch (Exception ex){
            return new ResponseModel(false,ex.getMessage());
        }

    }
    public ResponseModel deleteFromCart(CartItem cartItem)
    {
        try {
            db.cartItemDao().DeleteCartItem(cartItem);
            return new ResponseModel(true,"Delete from Cart Success");
        }
        catch (Exception ex){
            return new ResponseModel(false,ex.getMessage());
        }

    }
    public ResponseModel updateCart(CartItem cartItem)
    {
        try {
            db.cartItemDao().updateCartItem(cartItem);
            return new ResponseModel(true,"Update from Cart Success");
        }
        catch (Exception ex){
            return new ResponseModel(false,ex.getMessage());
        }

    }
}
