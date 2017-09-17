package com.android.mvpsample;

/**
 * Created by Tejshree on 17-09-2017.
 */

public class MainPresenterImpl implements MainInterface.MainPresenter {

    private MainInterface.MainInteractor mainInteractor;
    private MainInterface.MainView mainView;

    public MainPresenterImpl(MainInterface.MainView mainView) {
        this.mainView = mainView;
        mainInteractor = new MainInteractorImpl();
    }

    @Override
    public void clicked() {
        mainInteractor.clickedUpdateUI(this);
    }

    @Override
    public void operationDone(Model model) {
        mainView.clickedAction(model);
    }

    @Override
    public void textHasChanged(String value) {
        mainInteractor.updateTextValue(value, this);
    }

    @Override
    public void updateDone(String s) {
        mainView.showToast(s);
    }
}