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
 * {@link TicketIndexFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class TicketIndexFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public TicketIndexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ticket_index,container,false);
        final RadioGroup seatGroup = view.findViewById(R.id.group_tempatduduk);
        final EditText dewasaText = view.findViewById(R.id.input_dewasa);
        final EditText anakText = view.findViewById(R.id.input_anak);
        Button checkoutBtn = view.findViewById(R.id.button_checkout);
        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    String dewasaString = dewasaText.getText().toString();
                    String anakString = anakText.getText().toString();
                    int checkedId = seatGroup.getCheckedRadioButtonId();
                    if ((checkedId != -1) && !TextUtils.isEmpty(dewasaString) && !TextUtils.isEmpty(anakString)){
                        int dewasa = Integer.parseInt(dewasaString);
                        int anak = Integer.parseInt(anakString);
                        int seat = (checkedId== R.id.radio_reguler) ? SumSewa.REGULER :
                                (checkedId==R.id.radio_sweet) ? SumSewa.SWEET :
                                        SumSewa.FAMILY;
                        SumSewa sumSewa = new SumSewa(anak,dewasa,seat);
//                        sumSewa.setAnak(anak);
//                        sumSewa.setDewasa(dewasa);
//                        sumSewa.setSeat(checkedId);
                        mListener.onCalculateTiket(sumSewa.getIndex());
                    }else{
                        Toast.makeText(getActivity(),"Please fill amount adult,child and SEAT",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
        void onCalculateTiket(int index);
//        void onHitung(int total);
//        void onTicketIndexButtonClicked();
    }
}
