package com.android.mvpsample;

/**
 * Created by Tejshree on 17-09-2017.
 */

public interface MainInterface {

    public interface MainView{

        void clickedAction(Model model);

        void showToast(String s);
    }

    public interface MainPresenter{

        void clicked();

        void operationDone(Model model);

        void textHasChanged(String value);

        void updateDone(String s);
    }

    public interface MainInteractor{

        void clickedUpdateUI(MainPresenter presenter);

        void updateTextValue(String value, MainPresenterImpl mainPresenter);
    }
}
