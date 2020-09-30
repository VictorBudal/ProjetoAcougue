/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author Victor Budal
 * @param <Request>
 * @param <Response>
 */
public interface UseCase<Request,Response> {
    Response execute(Request arg);
}
