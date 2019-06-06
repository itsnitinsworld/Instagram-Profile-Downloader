package com.blackpaper.InstaDownload.stories.profile.post.download.data.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import com.blackpaper.InstaDownload.stories.profile.post.download.data.room.tables.Logins;


@Dao
public interface LoginsDao {

    @Query("Select * From login_table")
    LiveData<List<Logins>> getAllUsers();

    @Query("Select * From login_table Where id = :id")
    Logins getSelectedUser(int id);

    @Insert
    long insert(Logins logins);

    @Query("Delete From login_table Where id = :id")
    int delete(int id);



    @Query("UPDATE login_table\n" +
            "SET user_name = :username, profile_pic = :userProfileImage\n" +
            "WHERE id=:id;")
    void updateUserNameInfo(Integer id,String username,String userProfileImage);


}
