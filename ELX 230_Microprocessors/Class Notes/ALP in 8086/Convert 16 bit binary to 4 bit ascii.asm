

;.dosseg
.model huge
.data
    value dw 111ah

.code
    main proc far
        mov ax,@data
        mov ds,ax
        
        ;mov ax,0
        mov ax,value
        
        xor dx,dx
        mov cx,100
        
        div cx     ;;dx contains remainder ax quotient
 
        AAM
        ADD ax,3030h
        
        XCHG ax,dx      ;;ax = remainder, dx= quotient
        
        AAM
        ADD ax,3030h           
                  
                  ;;;;;;;;;;;;  
                  
        push ax
        
        
        mov bl,dl
        mov dl,dh
        mov ah,02h 
        int 21h
        
        mov dl,bl
        int 21h
        
        pop ax
        xchg ax,dx 
        
                mov bl,dl
        mov dl,dh
        mov ah,02h 
        int 21h
        
        mov dl,bl
        int 21h
        

                    ;;;;;;;;;;;;;;;
        mov ah,4ch
        int 21h
        
        main endp
    end main
        
        