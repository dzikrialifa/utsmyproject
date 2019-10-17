package org.android.dzik.mytshirt.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.android.dzik.mytshirt.R;
import org.android.dzik.mytshirt.sum.SumSewa;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TiketIndexFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class TiketIndexFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public TiketIndexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_tiket_index, container, false);
        View view = inflater.inflate(R.layout.fragment_tiket_index,container,false);

        final RadioGroup groupDuduk = view.findViewById(R.id.group_tempatduduk);
        final EditText pemesanText = view.findViewById(R.id.input_pemesan);
        final EditText dewasaText = view.findViewById(R.id.input_dewasa);
        final EditText anakText = view.findViewById(R.id.input_anak);
        Button hitungButton = view.findViewById(R.id.button_checkout);

        hitungButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    String jumlahDewasa = dewasaText.getText().toString();
                    String jumlahAnak = anakText.getText().toString();

                    int checkedId = groupDuduk.getCheckedRadioButtonId();
                    if ((checkedId != -1) && !TextUtils.isEmpty(jumlahAnak) && !TextUtils.isEmpty(jumlahDewasa)){
                        int hDewasa = Integer.parseInt(jumlahDewasa);
                        int hAnak = Integer.parseInt(jumlahAnak);
//                        int tipeDuduk = (checkedId == R.id.radio_reguler) ? SumSewa.REGULER "(checkedId == R.id.radio_sweet) ? SumSewa.SWEET : SumSewa.SWEET;
                        int tipeDuduk = (checkedId == R.id.radio_reguler) ? SumSewa.REGULER :
                                        (checkedId == R.id.radio_sweet) ? SumSewa.SWEET : SumSewa.FAMILY;
                        SumSewa sumSewa = new SumSewa(hAnak,hDewasa,tipeDuduk);
                        mListener.onCalculateTicket(sumSewa.getIndex());
                    }else{
                        Toast.makeText(getActivity(),"Please select gender and input your height",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
        void onCalculateTicket(int index);
    }
}
