package com.android.mvpsample;

/**
 * Created by Tejshree on 17-09-2017.
 */

public class MainInteractorImpl implements MainInterface.MainInteractor {

    @Override
    public void clickedUpdateUI(MainInterface.MainPresenter presenter) {

        //updation
        Model model=new Model();
        model.setName("Preeti");

        presenter.operationDone(model);
    }

    @Override
    public void updateTextValue(String value, MainPresenterImpl mainPresenter) {
        //Update value
        mainPresenter.updateDone("Update done");
    }
}
